import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> result = new Stack();

        for (String s : split) {
            if (s.equals("..") && !result.isEmpty()) {
                result.pop();
                continue;
            }
            if (s.isEmpty() || s.equals(".") || s.equals("..")) {
            } else {
                result.push(s);
            }
        }

        String canonicalPath = result.stream().reduce("", (acc, element) -> acc + "/" + element);
        return canonicalPath.isEmpty()? "/" : canonicalPath;
    }
}
