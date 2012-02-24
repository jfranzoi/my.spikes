package my;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Display {

	private final Writer output;

	public Display(Writer output) {
		this.output = output;
	}
	
	public void diplay_ResizedTo(List<Integer> values, int size) throws IOException {
		compose(asPictures(values, size)).appendTo(output);
	}

	public AsciiPicture compose(List<AsciiPicture> pictures) {
		int first = 0;
		int second = 1;
		
		AsciiPicture composed = pictures.get(first);
		for (AsciiPicture eachPicture : CollectionHelper.collect_StartingFrom(pictures, second)) {
			composed = composed.join(AsciiPicture.SPACE).join(eachPicture);
		}
		return composed;
	}

	private List<AsciiPicture> asPictures(List<Integer> values, int size) {
		List<AsciiPicture> pictures = new ArrayList<AsciiPicture>();
		for (Integer eachValue : values) {
			pictures.add(AsciiPictures.asPicture(eachValue, size));
		}
		return pictures;
	}


}
