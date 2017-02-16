package oneToten;

public class AddTwoNumbers {
	
   class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val=x;
		}
	}

	public static void main(String[] args) {
		AddTwoNumbers addTwoNumbers=new AddTwoNumbers();
		ListNode p,l;
		ListNode l1=addTwoNumbers.new ListNode(2);
		ListNode l2 = addTwoNumbers.new ListNode(4); 
        ListNode l3 = addTwoNumbers.new ListNode(3); 
        ListNode l4 = addTwoNumbers.new ListNode(5); 
        ListNode l5 = addTwoNumbers.new ListNode(6); 
        ListNode l6 = addTwoNumbers.new ListNode(4); 
        //��һ����
        l1.next=l2;
        l2.next=l3;
        l3.next=null;
        //�ڶ�����
        l4.next=l5;
        l5.next=l6;
        l6.next=null;
        l=addTwoNumbers.addTwoNumbers(l1, l4);
        for(p=l;p!=null;p=p.next)  
            System.out.println(p.val);  
	}
	
	public ListNode addTwoNumbers(ListNode l1,ListNode l2){
		return helper(l1,l2,0);
	}
	
	public ListNode helper(ListNode l1,ListNode l2,int carry){
		if(l1==null&&l2==null){       //ȫ��Ϊnullʱ�����ؽ�λֵ
			return carry==0?null:new ListNode(carry);
		}
		if(l1==null&&l2!=null){       //λ�������ʱ����ȱ�ٵ�λ��������
			l1=new ListNode(0);
		}
		if(l1!=null&&l2==null){       //λ�������ʱ����ȱ�ٵ�λ��������
			l2=new ListNode(0);
		}
		//����Ϊnullʱ����������ListNode�ͽ�λ��ӵ�ֵ
		int sum=l1.val+l2.val+carry;
		ListNode curr=new ListNode(sum%10);
		curr.next=helper(l1.next, l2.next, sum/10);
		return curr;
	}
}
