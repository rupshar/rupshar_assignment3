package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; //load this array
  private int size;
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]

  public MinBinHeap() {
    this.array = new EntryPair[arraySize];
    this.size = 0;
    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
                                             //of child/parent computations...
                                             //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  public EntryPair[] getHeap() { 
    return this.array;
  }

	@Override
	public void insert(EntryPair entry) {
		EntryPair new_pair = entry;
		if(size == 0) {
			array[1] = new_pair;
			size++;
		} else {
			array[this.size + 1] = new_pair;
			int parent_indx = (int) Math.floor((this.size+1)/2);
			int bubble_indx = this.size + 1;
			while(array[bubble_indx].getPriority() < array[parent_indx].getPriority()) {
				EntryPair temp = array[parent_indx];
				array[parent_indx] = array[bubble_indx];
				array[bubble_indx] = temp;
				bubble_indx = parent_indx;
				parent_indx = (int) Math.floor(bubble_indx / 2);
			}
			size++;
		}
		
	}
	
	@Override
	public void delMin() {
		EntryPair last_element = array[this.size];
		int last_indx = this.size;
		int parent_indx = (int) Math.floor(last_indx / 2);
		
		int last_priority = array[last_indx].getPriority();
		String last_value = array[last_indx].getValue();
		
		int hole = 1;
		array[1] = null;
		
		int hole_indx = bubbleHoleDown(hole, last_priority);
		
		array[hole_indx] = new EntryPair(last_value, last_priority);
		
		array[last_indx] = null;
		
		size--;
		
	}
	
	public int bubbleHoleDown(int hole_indx, int last_priority) {
		int location_of_hole = hole_indx;
		int last = last_priority;
		int left_indx = location_of_hole * 2;
		int right_indx = (location_of_hole * 2) + 1;
		
		if(left_indx > size) {
			return location_of_hole;
		} else {
			EntryPair left_child = array[left_indx];
			EntryPair right_child = array[right_indx];
			
			while(last > left_child.getPriority()) {
				if(right_indx < this.size) {
					int left_priority = left_child.getPriority();
					int right_priority = right_child.getPriority();
					
					if(left_priority < right_priority) {
						array[location_of_hole] = array[left_indx];
						array[left_indx] = null;
						location_of_hole = left_indx;
					} else {
						array[location_of_hole] = array[right_indx];
						array[right_indx] = null;
						location_of_hole = right_indx;
					}
				} else {
					array[location_of_hole] = array[left_indx];
					array[left_indx] = null;
					location_of_hole = left_indx;
					left_indx = location_of_hole * 2;
				}
				
				left_indx = location_of_hole * 2;
				right_indx = (location_of_hole * 2) + 1;
				
				left_child = array[left_indx];
				right_child = array[right_indx];
				
				if(left_indx > size) {
					break;
				}
			}
			return location_of_hole;
		}

		
	}
	
	@Override
	public EntryPair getMin() {
		return array[1];
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void build(EntryPair[] entries) {
		
		for(int i = 0; i < entries.length; i++) {
			insert(entries[i]);
		}
		
		int start_indx = (int) Math.floor(size/2);
		
		for (int i = start_indx; i > 0; i--) {
			heapify(array, size, i);
		}
		
	}
	
	public void heapify(EntryPair[] entries, int size, int i) {
		
		int smallest = i;
		int l = (2 * i);
		int r = (2 * i) + 1;
		
		if (l < size && entries[l].getPriority() < entries[smallest].getPriority()) {
			smallest = l;
		}
		
		if (r < size && entries[r].getPriority() < entries[smallest].getPriority()) {
			smallest = r;
		}
		
		if (smallest != i) {
			EntryPair swap = entries[i];
			array[i] = entries[smallest];
			array[smallest] = swap;
			
			heapify(array, size, smallest);
		}
		
	}
}
