package typeInference;

import java.util.ArrayList;

public class BoxDemo {

    public <U> void addBox(U u, ArrayList<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.setT(u);
        boxes.add(box);
    }
}
