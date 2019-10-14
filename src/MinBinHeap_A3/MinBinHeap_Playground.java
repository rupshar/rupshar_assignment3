package MinBinHeap_A3;

public class MinBinHeap_Playground {
  public static void main(String[] args){   
    //Add more tests as methods and call them here!!
    //TestBuild();
	  
	test();
  }
  
  public static void test() {
	  MinBinHeap mbh = new MinBinHeap();
	  EntryPair[] collection = new EntryPair[2];
	  collection[0] = new EntryPair("a", 3);
	  collection[1] = new EntryPair("b", 8);
	  
	  mbh.build(collection);
	  
	  mbh.insert(new EntryPair("c", 1));
	  mbh.insert(new EntryPair("d", 6));
	  mbh.insert(new EntryPair("e", 5));
	  mbh.insert(new EntryPair("f", 4));
	  mbh.insert(new EntryPair("g", 7));
	  mbh.insert(new EntryPair("h", 2));
	  mbh.insert(new EntryPair("i", 9));
	  mbh.insert(new EntryPair("j", 0));
	  
	  mbh.delMin();
	  mbh.delMin();
	  mbh.delMin();
	  
	  System.out.println("Size: " + mbh.size());
	  
	  System.out.println("Min: " + mbh.getMin().getPriority());
	  
	  mbh.insert(new EntryPair("p", 0));
	  mbh.insert(new EntryPair("q", 10));
	  
	  System.out.println(mbh.getMin().getPriority());
	  
	  System.out.println("Size: " + mbh.size());
	  
	  for(int i=1;i < mbh.size() + 1;i++){
	      System.out.print("("+mbh.getHeap()[i].value+","+mbh.getHeap()[i].priority+")\t");
	    }
	  
  }
  
  public static void TestBuild(){ 
    // constructs a new minbinheap, constructs an array of EntryPair, 
    // passes it into build function. Then print collection and heap.
    MinBinHeap mbh= new MinBinHeap();
    EntryPair[] collection= new EntryPair[8];
    collection[0]=new EntryPair("i",3);
    collection[1]=new EntryPair("b",5);
    collection[2]=new EntryPair("c",1);
    collection[3]=new EntryPair("d",0);
    collection[4]=new EntryPair("e",46);
    collection[5]=new EntryPair("f",5);
    collection[6]=new EntryPair("g",6);
    collection[7]=new EntryPair("h",17);
    mbh.build(collection);
    printHeapCollection(collection);
    printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void printHeapCollection(EntryPair[] e) { 
    //this will print the entirety of an array of entry pairs you will pass 
    //to your build function.
    System.out.println("Printing Collection to pass in to build function:");
    for(int i=0;i < e.length;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
  
  public static void printHeap(EntryPair[] e,int len) { 
    //pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th index....
    System.out.println("Printing Heap");
    for(int i=1;i < len+1;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
}