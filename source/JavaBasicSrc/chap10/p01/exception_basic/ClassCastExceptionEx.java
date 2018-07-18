package p01.exception_basic;

public class ClassCastExceptionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dog dog = new Dog();
		changeDog(dog);
		System.out.println("dog changeDog method 호출후");
		
		Cat cat = new Cat();
		//	cat을 changeDog에 적용할 때 Dog로 cast(강제형변환)하지 못해
		//	ClassCastException 발생
		changeDog(cat);
		
		public static void changeDog(Animal animal)
		{
			if(animal instanceof Dog)
			{
				System.out.println("animal instanceof");
				Dog dog = (Dog) animal;
			}
			else
			{
				System.out.println("Dog으로 change 불가");
			}
		}
	}

}

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}
