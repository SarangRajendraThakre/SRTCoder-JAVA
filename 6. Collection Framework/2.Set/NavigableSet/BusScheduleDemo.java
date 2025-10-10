import java.util.*;

public class BusScheduleDemo {
    public static void main(String[] args) {
        NavigableSet<Integer> busTimes = new TreeSet<>();

        // Add bus departure times (in minutes from midnight)
        busTimes.add(480);  // 08:00 AM
        busTimes.add(600);  // 10:00 AM
        busTimes.add(720);  // 12:00 PM
        busTimes.add(900);  // 03:00 PM
        busTimes.add(1140); // 07:00 PM

        System.out.println("Bus Timetable (minutes from midnight): " + busTimes);

        // lower() - Find bus strictly before 10:30 (630)
        System.out.println("Bus before 10:30 -> " + busTimes.lower(630));  

        // floor() - Find bus at or before 10:00 (600)
        System.out.println("Bus at or before 10:00 -> " + busTimes.floor(600)); 

        // ceiling() - Find bus at or after 11:00 (660)
        System.out.println("Bus at or after 11:00 -> " + busTimes.ceiling(660));

        // higher() - Find bus strictly after 12:00 (720)
        System.out.println("Bus after 12:00 -> " + busTimes.higher(720));

        // pollFirst() - First bus leaves and is removed
        System.out.println("First bus departed at: " + busTimes.pollFirst());
        System.out.println("After pollFirst: " + busTimes);

        // pollLast() - Last bus leaves and is removed
        System.out.println("Last bus departed at: " + busTimes.pollLast());
        System.out.println("After pollLast: " + busTimes);

        // descendingSet() - Reverse view of remaining buses
        System.out.println("Buses in reverse order: " + busTimes.descendingSet());

        // descendingIterator() - Iterate in reverse
        System.out.print("Iterating reverse: ");
        Iterator<Integer> it = busTimes.descendingIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // subSet() - Buses between 09:00 (540) and 04:00 PM (960)
        NavigableSet<Integer> midDayBuses = busTimes.subSet(540, true, 960, true);
        System.out.println("Mid-day buses (09:00–16:00): " + midDayBuses);

        // headSet() - Buses before or at 12:00 (720)
        NavigableSet<Integer> morningBuses = busTimes.headSet(720, true);
        System.out.println("Morning buses (<= 12:00): " + morningBuses);

        // tailSet() - Buses after 12:00 (720)
        NavigableSet<Integer> eveningBuses = busTimes.tailSet(720, false);
        System.out.println("Evening buses (> 12:00): " + eveningBuses);
    }
}
