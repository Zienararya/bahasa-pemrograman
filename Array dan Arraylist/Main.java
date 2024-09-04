import java.util.*;
public class Main {
    public static void main(String[] args) {
        ArrayList<String> pastry = new ArrayList<String>();
        pastry.add("Rainbow Cake");
        pastry.add("Oreo Choco Cheese");
        pastry.add("Macaroon");
        pastry.add("Eclairs");
        System.out.println(pastry);
        pastry.add(2, "Brownies");
        pastry.add(5, "Strawberry Cheese Cake");
        System.out.println(pastry);
        ArrayList<String> cake = new ArrayList<String>();
        cake.add("Black Forest");
        cake.add("Tiramisu");
        cake.add("Red Velvet");
        pastry.addAll(3, cake);
        System.out.println(pastry);
        String element = pastry.get(4);
        System.out.println(element);
        String element1 = pastry.get(6);
        System.out.println(element1);
        System.out.println("Rainbow Cake berada pada elemen ke- "+ pastry.indexOf("Rainbow Cake"));
        System.out.println("Red Velvet berada pada elemen ke- "+pastry.indexOf("Red Velvet"));
        System.out.println("Strawberry Cheese Cake berada pada elemen ke- " +pastry.indexOf("Strawberry Cheese Cake"));
        pastry.add (7, "Bread Puding");
        pastry.add (8, "Cronut");
        String[] cakes1= new String[0];
        cakes1 = pastry.toArray(cakes1);
        for (String item : cakes1) {
        System.out.println(item);
        }
        System.out.println();
        for (int i = 0; i < pastry.size(); i++) {
        System.out.println(pastry.get(i) + " ");
        }
        System.out.println();
        ListIterator<String> listIterator =
        pastry.listIterator();
        while(listIterator.hasNext()) {
        System.out.println(listIterator.next() + " ");
        }
        System.out.println();
        while(listIterator.hasPrevious()) {
        System.out.println(listIterator.previous() + " ");
        }
        System.out.println();
        Collections.sort(pastry);
        System.out.println(pastry);
        pastry.set(pastry.size()-1, "Choco Lave");
        System.out.println(pastry);
        pastry.remove(10);
        pastry.remove(9);
        pastry.remove(7);
        pastry.remove(1);
        System.out.println(pastry);
        pastry.remove("Cronut");
        System.out.println(pastry);
        pastry.removeAll(cake);
        System.out.println(pastry);
        pastry.clear();
        System.out.println(pastry);
    }
}