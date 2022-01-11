import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PetyaEnvelope {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String[] first = reader.readLine().split(" ");

        int envelopeAmount = Integer.parseInt(first[0]);
        int postcardHeight = Integer.parseInt(first[1]);
        int postcardWidth = Integer.parseInt(first[2]);

        List<Envelope> envelopeList = new ArrayList<>();

        for (int i = 0; i < envelopeAmount; i++) {
            String[] envelope = reader.readLine().split(" ");
            int envelopeHeight = Integer.parseInt(envelope[0]);
            int envelopeWidth = Integer.parseInt(envelope[1]);

            long multiply = (long) envelopeWidth * envelopeHeight;
            if (envelopeHeight > postcardHeight && envelopeWidth > postcardWidth) {
                envelopeList.add(new Envelope(envelopeHeight, envelopeWidth, multiply, i + 1));
            }
        }

        if (!envelopeList.isEmpty()) {
            envelopeList.sort(Comparator.comparing(Envelope::getMultiply));

            int size = envelopeList.size();

            int[] chain = new int[size];
            int[] p = new int[size];

            for (int i = 0; i < size; i++) {
                chain[i] = 1;
                p[i] = -1;
                for (int j = 0; j < i; j++) {
                    Envelope env = envelopeList.get(i);
                    Envelope env1 = envelopeList.get(j);
                    if (env1.height < env.height && env1.width < env.width && 1 + chain[j] > chain[i]) {
                        chain[i] = 1 + chain[j];
                        p[i] = j;
                    }
                }
            }

            int ans = chain[0], pos = 0;

            for (int i = 0; i < size; i++) {
                if (chain[i] > ans) {
                    ans = chain[i];
                    pos = i;
                }
            }

            List<Integer> result = new ArrayList<>();

            while (pos != -1) {
                result.add(pos);
                pos = p[pos];
            }

            printResult(result.stream().map(index -> envelopeList.get(index).number).collect(Collectors.toList()));
        } else {
            System.out.println("0");
        }
    }

    private static void printResult(List<Integer> envelops) {
        System.out.println(envelops.size());

        Collections.reverse(envelops);
        if (envelops.size() > 0) {
            for (Integer env : envelops) {
                System.out.print(env + " ");
            }
        }
    }

    static class Envelope {
        public Envelope(int height, int width, long multiply, int number) {
            this.height = height;
            this.width = width;
            this.number = number;
            this.multiply = multiply;
        }

        int height;
        int width;
        long multiply;
        int number;

        public long getMultiply() {
            return multiply;
        }
    }
}
