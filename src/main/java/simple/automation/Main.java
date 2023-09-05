package simple.automation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("один", "два", "три");
        List<String> list2;

        Map<String, Integer> digestMap = new HashMap<>();
        digestMap.put("один", 1);
        digestMap.put("два", 2);
        digestMap.put("три", 3);

        list.forEach(str -> System.out.println(digestMap.get(str)));
        list2 = list.stream().filter(el -> el.length() == 3).collect(Collectors.toList()); // новый список с элементами длиной 3 символа
        list2.forEach(str -> System.out.println(str));
}

    private <T> String objectToString(T object){
        return String.valueOf(object);
    }
}