import java.util.ArrayList;

public class MyArrayList<E> 
{
  private int size; // Number of elements in the list
  private E[] data;
  private int winnigValue ;
  /** Create an empty list */
  public MyArrayList() {
	   data = (E[])new Object[100];// cannot create array of generics
       size = 0; // Number of elements in the list
  }

  public void setWinning (int win) {
    this.winnigValue = win;
  }
  public ArrayList<Character> checkChar(String word, String user) {
    //word = "admin";
     //user = ;

    user = user.toLowerCase();

    int wordLength = 5;

    int win = 0;

    char[] Record = new char[wordLength];

    int[] charNumber = new int[wordLength];
    
    for (int i = 0; i < wordLength; i++) {
        charNumber[i] = user.charAt(i);
    }
    // changing input to char
    for (int i = 0; i < wordLength; i++) {
        int present = charNumber[i];

        for (int j =0; j < wordLength; j++) {
            int userPresent = word.charAt(j);

            if (userPresent == present) {
                if (i == j) {
                    Record[i] = 'A';
                    j = 5;
                } else {
                    Record[i] = 'B';
                    j = 5;
                }
            } else if(userPresent != present) {
                // C shouldn't be the final answer but A and B can be the final answer
                Record[i] = 'C';
                //j = 5;
            }
        }

    }
    

    ArrayList<Character> RRecord = new ArrayList<>();
    for (int i = 0; i < wordLength ; i ++) {
        RRecord.add(i, Record[i]);
    }

    setWinning(win);
    System.out.println("*******Here is what the letters mean: \nA = valid characters and in its correct position \nB = valid characters but not in its correct position \nC = Not a valid character.");

    return RRecord;
    
}

public void checkWin() {
    int win = this.winnigValue;
    if (win == 5) {

        System.out.println("Congrats");

    } else {
        System.out.println("Hade Mfana!!!");
    }
}
  
  public void add(int index, E e) {   
    // Ensure the index is in the right range
    if (index < 0 || index > size)
      throw new IndexOutOfBoundsException
        ("Index: " + index + ", Size: " + size); 
    // Move the elements to the right after the specified index
    for (int i = size - 1; i >= index; i--)
      data[i + 1] = data[i];
    // Insert new element to data[index]
    data[index] = e;
    // Increase size by 1
    size++;
  }

  public boolean contains(Object e) {
    for (int i = 0; i < size; i++)
      if (e.equals(data[i])) return true;
    return false;
  }

  public E get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException
        ("Index: " + index + ", Size: " + size);
    return data[index];
  }
  
  public E remove(int index) {
	if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException
        ("Index: " + index + ", Size: " + size);
    E e = data[index];
    // Shift data to the left
    for (int j = index; j < size - 1; j++)
      data[j] = data[j + 1];
    data[size - 1] = null; // This element is now null
    // Decrement size
    size--;
    return e;
  }

  public String toString() {
    String result=" ";
    for (int i = 0; i < size; i++) {
      result+= data[i];
      if (i < size - 1) result+=", ";
    }
    return result.toString() + "]";
  }

  
  public int size() {
    return size;
  }
  
 public boolean sortList() {
    E hold;
	for (int i = 0; i < size-1; i++)
	 {
	   for (int j = 0; j<size-1; j++)
	    {  	 
	     if(((Comparable)data[j]).compareTo(data[j+1])>0)
	      {
	       hold= data[j+1];
	       data[j+1]=data[j];
	       data[j]=hold;
	      }       
	   }
     } 
	 return true;	  	
  }


 
}