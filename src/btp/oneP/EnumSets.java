package btp.oneP;

import java.util.EnumSet;

public class EnumSets {

	public static void main(String[] args) {
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
		points.add(AlarmPoints.BATHROOM);
		System.out.println(points);
		points.addAll(EnumSet.of(AlarmPoints.START1, AlarmPoints.START2, AlarmPoints.KITCHEN));
		System.out.println(points);
		points = EnumSet.allOf(AlarmPoints.class);
		points.removeAll(EnumSet.of(AlarmPoints.START1, AlarmPoints.START2, AlarmPoints.KITCHEN));
		System.out.println(points);
		points.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
		System.out.println(points);
		points = EnumSet.complementOf(points);
		System.out.println(points);
		points = EnumSet.complementOf(EnumSet.allOf(AlarmPoints.class));
		System.out.println(points);
		points = EnumSet.complementOf(EnumSet.noneOf(AlarmPoints.class));
		System.out.println(points);
	}

}

enum AlarmPoints{
	START1,START2,LOBBY,OFFICE1,OFFICE2,OFFICE3,OFFICE4,BATHROOM,UTILITY,KITCHEN
}
