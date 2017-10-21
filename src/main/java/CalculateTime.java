import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CalculateTime {

	public static String content = "It was the best of times, it was the worst of times,\n"
			+ "it was the age of wisdom, it was the age of foolishness,\n"
			+ "it was the epoch of belief, it was the epoch of incredulity,\n"
			+ "it was the season of Light, it was the season of Darkness,\n"
			+ "it was the spring of hope, it was the winter of despair,\n"
			+ "we had everything before us, we had nothing before us";

	public static void main(String[] args) {

		String fileName = "/home/swastika/File.txt";
		try {
			writeToFile(fileName);

			long startTime = System.currentTimeMillis();
			System.out.println(readDataFromRAM());
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println(totalTime);

			System.out.println("---------------Done Reading From RAM--------------------------------");

			startTime = System.currentTimeMillis();
			System.out.println(readDataFromFile(fileName));
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			System.out.println(totalTime);

			System.out.println("---------------Done Reading From File--------------------------------");
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static String readDataFromRAM() {
		return content;
	}

	public static String readDataFromFile(String fileName) throws IOException {
		StringBuilder contentBuilder = new StringBuilder();
		try (Stream<String> stream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		}
		return contentBuilder.toString();
	}

	public static void writeToFile(String fileName) throws IOException {
		Files.write(Paths.get(fileName), content.getBytes());
	}

}
