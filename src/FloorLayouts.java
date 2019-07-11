
public class FloorLayouts {

	boolean[][] layout1;

	FloorLayouts() {

		///////////////////////////////
		layout1 = new boolean[5][5];

		for (int i = 0; i < 5; i++) {
			layout1[i][0] = true;
		}

		///////////////////////////////
	}

	boolean[][] getInfo(int layout) {

		if (layout == 1) {
			return layout1;
		} else {
			return null;
		}

	}

}
