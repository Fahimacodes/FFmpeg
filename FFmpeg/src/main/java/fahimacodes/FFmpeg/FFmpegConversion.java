package fahimacodes.FFmpeg;

import java.io.File;

/**
 * Convert audio file of type .M4A to audio file of type .WAV. 
 * Install FFMpeg - https://www.wikihow.com/Install-FFmpeg-on-Windows
 * Add path to Environment Variables --> System Variables
 * @author fahimacodes
 **/
public class FFmpegConversion {
	public static void main(String[] args) {

		FFmpegConversion conversion = new FFmpegConversion();

		String originalFileName = "audio_only";
		String convertedFileName = "converted";
		// Definition/Alternate command parameters --> https://ffmpeg.org/ffmpeg.html
		String command = "ffmpeg -i "+originalFileName+".m4a -c:a pcm_mulaw -ar 8000 -ac: 2 "+ convertedFileName+".wav";
		String directory = "DIRECTORY WHERE ORIGINAL FILE LOCATED";

		conversion.convert(command, directory);
	}

	private void convert(String command, String dir) {
		StringBuilder output = new StringBuilder();
		try {
			Process process = Runtime.getRuntime().exec(command, null, new File(dir));
			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Successfully converted!" + output);
				System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
