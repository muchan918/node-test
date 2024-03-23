
import java.util.Scanner;

class IntArray{ //정수를 담는 객체
	private int number; //객체가 가지는 정수 = 멤버변수
	
	public IntArray(int number) {
		this.number = number; //number값을 받는 생성자
	}
	
	public int getArray() { return number; } //getter 함수
	public void setArray(int number) { this.number = number; } // setter 함수
}

public class BinaryArray {
	private IntArray arrays[][] = null;//2차원 배열 초기화 = 레퍼런스 생성
	private int criticalValue; // 매개변수 임계값
	
	public void inputAndChange() {
		Scanner scanner = new Scanner(System.in);//scanner 객체 생성 한번만 받으므로 여기에 생성
		System.out.print("임계값을 입력하세요>>");
		criticalValue = scanner.nextInt();//scanner로 입력받은 정수를 임계값에 저장
		
		for(int i=0; i<4; i++) { //배열 안에서 임계값 기준으로 판단하고 고치는 반복문
			for(int j=0; j<4; j++) {
				if (arrays[i][j].getArray() > criticalValue)//배열 값이 임계값보다 크면
					arrays[i][j].setArray(1);//1로 세팅
				else //배열 값이 임계값보다 작으면
					arrays[i][j].setArray(0);//0으로 세팅
			}
		}
	}
	
	public void print() { //배열 출력해주는 함수
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				System.out.printf(arrays[i][j].getArray() + "\t");
			}
			System.out.print("\n");
		}
	}
	
	public void createArray() { //배열 생성해주는 함수
		arrays = new IntArray[4][4]; 
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
			int random = (int)(Math.random()*256); //랜덤한 값 받기
			arrays[i][j] = new IntArray(random); //랜덤한 값 객체에 넣어주기
			}
		}
		System.out.println("0~255 사이의 정수를 랜덤하게 저장했습니다.");
		
	}
	
	public void run() {
		createArray(); //배열을 생성해주는 함수
		print(); //배열을 출력해주는 함수
		inputAndChange();//숫자를 입력받고 배열을 고치는 함수
		System.out.println("변형한 binary 배열을 출력합니다");
		print();//배열을 출력해주는 함수
		
	}
	
	public static void main(String[] args) {
		BinaryArray app = new BinaryArray();//메인에서 생성되는 생성자
		app.run(); // 메인 실행함수
	}

}
