import java.util.Arrays;
import java.util.Stack;

public class DesertPass {

    public static final String NORTH = "NORTH";
    public static final String SOUTH = "SOUTH";
    public static final String EAST = "EAST";
    public static final String WEST = "WEST";

    public static void main(String[] args) {
        String[] request = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};
        System.out.println(Arrays.toString(dirReduce(request)));
    }

    public static String[] dirReduce(String[] arr) {

        Stack<String> route = new Stack<>();

        for (String value : arr) {
            if (route.isEmpty()) {
                route.push(value);
                continue;
            }
            String lastStep = route.peek();
            switch (value) {
                case NORTH:
                    if (SOUTH.equals(lastStep)) route.pop();
                    else route.add(value);
                    break;
                case SOUTH:
                    if (NORTH.equals(lastStep)) route.pop();
                    else route.add(value);
                    break;
                case EAST:
                    if (WEST.equals(lastStep)) route.pop();
                    else route.add(value);
                    break;
                case WEST:
                    if (EAST.equals(lastStep)) route.pop();
                    else route.add(value);
                    break;
            }
        }

        String[] result = new String[route.size()];

        for (int i = route.size() - 1 ; i >= 0; i--) {
            result[i] = route.pop();
        }

        return result;
    }
}
