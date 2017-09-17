package btp.oneP;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * 
 * Ӫҵ��ʵ��
 * ϵͳ�汾: v1.0<br>
 * ������Ա: @author baitp<br>
 * ����ʱ��: 2017��09��03��<br>
 */
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
public class Department implements Serializable,Comparable<Department>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6070094233812709878L;
	
	/*
	 * Ӫҵ�����ͣ�����Ӫҵ����0;����Ӫҵ��:1;�ܲ�:2;
	 */
	public static int SELF = 0;
	public static int BINDING = 1;
	public static int HQ = 2;
	
	public Department(){}
	
	
	public Department(double leisureLevel,double defectProbability, int orgType) {
		super();
		this.leisureLevel  = leisureLevel;
		this.orgType = orgType;
		this.defectProbability = defectProbability;
	}




	/*
	 *Ӫҵ����� 
	 */
	private String orgCode;
	/*
	 * ��ӦVideoQueuesAction.agentFBranchList�����ӦӪҵ����ϯ����
	 */
	private Map<Long, Agent> agentList;
	/*
	 * ������ϯ����
	 */
	private int freeAgentNum;
	
	/*
	 * ����ʲôӪҵ����
	 * �ֱ���Ӫҵ����0;����Ӫҵ����1;�ܲ�:2;
	 */
	private int orgType;

	/*
	 * �����̶ȣ���������/������
	 */
	private double leisureLevel;
	
	
	public double getLeisureLevel() {
		return leisureLevel;
	}


	public void setLeisureLevel(double leisureLevel) {
		this.leisureLevel = leisureLevel;
	}


	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public Map<Long, Agent> getAgentList() {
		return agentList;
	}

	public void setAgentList(LinkedHashMap<Long, Agent> agentList) {
		this.agentList = agentList;
	}

	public int getFreeAgentNum() {
		return freeAgentNum;
	}

	public void setFreeAgentNum(int freeAgentNum) {
		this.freeAgentNum = freeAgentNum;
	}

	public int getOrgType() {
		return orgType;
	}

	public void setOrgType(int orgType) {
		this.orgType = orgType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orgCode == null) ? 0 : orgCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (orgCode == null) {
			if (other.orgCode != null)
				return false;
		} else if (!orgCode.equals(other.orgCode))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "Department [orgType=" + orgType + ", leisureLevel=" + leisureLevel + ", defectProbability="
				+ defectProbability + "]\n";
	}




	//Ӫҵ���Ƚ��������ȼ���Ӫҵ������>���г̶�>ȱ����
    private static Comparator<Department> comparatorForDepartment = new Comparator<Department>(){
		@Override
		public int compare(Department d1, Department d2) {
			if(d1.getOrgType() > d2.getOrgType()){
				return 1;
			}else if(d1.getOrgType() < d2.getOrgType()){
				return -1;
			}else{
				if(d1.getLeisureLevel() > d2.getLeisureLevel()){
					return -1;
				}else if(d1.getLeisureLevel() < d2.getLeisureLevel()){
					return 1;
				}else{
					if(d1.getDefectProbability() > d2.getDefectProbability()){
						return 1;
					}else if(d1.getDefectProbability() < d2.getDefectProbability()){
						return -1;
					}else{
						return 0;
					}
				}
			}
		}
	};
	private double defectProbability;
	public double getDefectProbability() {
		return defectProbability;
	}

	public void setDefectProbability(double defectProbability) {
		this.defectProbability = defectProbability;
	}
	
	public static void main(String...args) {
		List<Department> dl = new ArrayList<>();
		Department self = new Department(0.98,0,1);
		dl.add(self);
		dl.add(new Department(1,0.88,1));
		dl.add(new Department(1,0.98,2));
		dl.add(new Department(1,1,1));
		dl.add(new Department(1,0.76,1));
		dl.add(new Department(1,0.23,1));
		dl.add(new Department(1,0.55,1));
		dl.add(new Department(1,0,1));
		Collections.sort(dl, comparatorForDepartment);
		System.out.println(dl);
		System.out.println("-------------------------");
		PriorityQueue<Department> pq = new PriorityQueue<>();
		pq.addAll(dl);
		System.out.println(pq.peek());
		self.setOrgType(1);
		System.out.println(pq.peek());
		pq.remove();
		pq.addAll(dl);
		System.out.println(pq.peek());
	}


	@Override
	public int compareTo(Department o) {
		if(this.getOrgType() > o.getOrgType()){
			return 1;
		}else if(this.getOrgType() < o.getOrgType()){
			return -1;
		}else{
			if(this.getFreeAgentNum() > o.getFreeAgentNum()){
				return -1;
			}else if(this.getFreeAgentNum() < o.getFreeAgentNum()){
				return 1;
			}else{
				return 0;
			}
		}
	}
	
}
