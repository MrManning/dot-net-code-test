package dot_net;

import java.util.Map;

class OutputPrinter {
    String printOutputToConsole(String output) {
        return output;
    }

    String printOutputToConsole(Map<String, Integer> theMap) {
        StringBuilder output = new StringBuilder();
        for(Map.Entry<String, Integer> entry : theMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            output.append(key).append(": ").append(value).append(", ");
        }
        int sum = theMap.values().stream().mapToInt(i -> i).sum();
        output.append("total: ").append(sum);

        return output.toString();
    }
}
