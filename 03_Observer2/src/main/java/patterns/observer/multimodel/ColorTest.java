package patterns.observer.multimodel;

import java.awt.Color;
import java.util.EnumSet;

import patterns.observer.multimodel.ColorModel.ColorChannel;

public class ColorTest {

	public static void main(String[] args) {
		final ColorModel model = new ColorModel(Color.BLACK);

		EnumSet<ColorChannel> all = EnumSet.allOf(ColorChannel.class);

		System.out.println(	all);


		model.addColorListener(c -> {
			if (Color.RED.equals(c)) {
				System.out.println("1. Listener RED");
				model.setColor(Color.GRAY);
			}
		}, all);

		model.addColorListener(c -> {
			System.out.println("Current color: " + c);
		}, all);

		model.setColor(Color.WHITE);
	}

}
