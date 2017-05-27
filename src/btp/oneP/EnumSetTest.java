package btp.oneP;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class EnumSetTest {

	public static void main(String[] args) {
		Set<Week> set1 = EnumSet.range(Week.Monday, Week.Thursday);
		Set<Week> set2 = EnumSet.range(Week.Wednesday, Week.Sunday);
		System.out.println(set1);
		System.out.println(set2);
		Set<Week> union = new HashSet<Week>(set1);
		union.addAll(set2);
		System.out.println("union:"+union);
		Set<Week> intersection = new HashSet<Week>(set1);
		intersection.retainAll(set2);
		System.out.println("intersection:"+intersection);
		Set<Week> difference = new HashSet<Week>(set1);
		difference.removeAll(set2);
		System.out.println("difference:"+difference);
		Set<Week> complement = new HashSet<Week>(union);
		complement.removeAll(intersection);
		System.out.println("complement:"+complement);
	}

}
enum Week{
	Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday
}