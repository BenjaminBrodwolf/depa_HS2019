package patterns.composite;

import java.util.LinkedList;
import java.util.List;

public class GroupFigure extends Figure {
    private String name;
    private List<Figure> figures = new LinkedList<>();

    public GroupFigure(String name, Figure... figures) {
        this.name = name;
        for (Figure f : figures) {
			addFigure(f);
        }
    }

    public void addFigure(Figure f)  {
		if (f.isGrouped()) {
			throw new IllegalArgumentException("Figures is already in a group");
		}
		if(f instanceof GroupFigure){
			List<Figure> figureList = ((GroupFigure) f).figures;
			for (Figure f2 : figureList) {
				addFigure(f2);
			}
		}
        System.out.println(name);
        System.out.println(f.toString());

        f.setGrouped(true);
        figures.add(f);
    }

    @Override
    public void draw(String prefix) {
        System.out.println(prefix + name);
        for (Figure f : figures) {
            f.draw(prefix + ">>");
        }
    }



}
