package my;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsciiPicture {

	public static final AsciiPicture SPACE	= new AsciiPicture(Arrays.asList(" ")){
		@Override
		protected String lineAt(int currentLine) {
			return " ";
		}
	};
	
	private final List<String> lines;

	public AsciiPicture(List<String> lines) {
		this.lines = lines;
	}

	public AsciiPicture join(AsciiPicture picture) {
		List<String> toReturn = new ArrayList<String>();
		
		for (int currentLine = 0; currentLine < lines.size(); currentLine++) {
			toReturn.add((lineAt(currentLine) + picture.lineAt(currentLine)));
		}
		
		return new AsciiPicture(toReturn);
	}
	
	public void appendTo(Writer writer) throws IOException {
		writer.append(formatWithNewlines());
	}
	
	public AsciiPicture resizedTo(int size) {
		List<String> result = new ArrayList<String>();
		
		for (int currentLine = 0; currentLine < lines.size(); currentLine++) {
			String middleCharacter = lineAt(currentLine).substring(1, 2);
			String resized = lineAt(currentLine).replaceFirst(middleCharacter, StringHelper.repeat_Times(size, middleCharacter));
			
			int timesToAdd = 1;
			if(isEven(currentLine+1)){
				timesToAdd = size;
			}
			
			CollectionHelper.add_Times_To(timesToAdd, resized, result);
		}
		return new AsciiPicture(result);
	}

	private String formatWithNewlines() {
		return StringHelper.joinWithNewLine(lines);
	}

	protected String lineAt(int currentLine) {
		return lines.get(currentLine);
	}
	
	@Override
	public boolean equals(Object anObject) {
		AsciiPicture picture = (AsciiPicture) anObject;
		return lines.equals(picture.lines);
	}
	
	@Override
	public int hashCode() {
		return lines.hashCode();
	}
	
	@Override
	public String toString() {
		return lines.toString();
	}

	private boolean isEven(int value) {
		return value % 2 == 0;
	}
}
