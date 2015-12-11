package protoc.test.person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import protoc.test.person.PersonProtos.Person;

public class PersonTest {
public static void main(String[] args) {
	Person person1 = Person.newBuilder().setName("chenxy")
	.setEmail("chenxy@china.com")
	.setId(111)
	.addPhone(Person.PhoneNumber.newBuilder().setNumber("5566666").setType(1))
	.addPhone(Person.PhoneNumber.newBuilder().setNumber("5481111").setType(2))
	.build();
	
	try {
		FileOutputStream out = new FileOutputStream("exeample.txt");
		person1.writeTo(out);
		out.close();
		
		FileInputStream in = new FileInputStream("exeample.txt");
		Person person2 = Person.parseFrom(in);
		System.out.println("person2"+person2);
		in.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
