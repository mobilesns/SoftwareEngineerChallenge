# Software Engineer Challenge
1. Coding task:

    In object-oriented and functional programming, an immutable object is an object whose state cannot be modified after it is created. This is in contrast to a mutable object which can be modified after it is created. 

    Classes should be immutable unless there's a very good reason to make them mutable. If a class cannot be made immutable, limit its mutability as much as possible. The JDK contains many immutable classes, including String, the boxed primitive classes, and BigInteger and etc. Basically the immutable classes are less prone to error. 

    Please implement an immutable queue with the following api:
	
    Scala Version:
    ```scala
	trait Queue[T] {
	  def isEmpty: Boolean
	  def enQueue(t: T): Queue[T]
	  # Removes the element at the beginning of the immutable queue, and returns the new queue.
	  def deQueue(): Queue[T]
	  def head: Option[T]
	}
	object Queue {
	  def empty[T]: Queue[T] = ???
	}
    ```

    Java Version:
    ```java
	public interface Queue[T] {
	    public Queue<T> enQueue(T t);
	    #Removes the element at the beginning of the immutable queue, and returns the new queue.
	    public Queue<T> deQueue();
	    public T head();
	    public boolean isEmpty();
	}
    ```
    
ANSWER:

    The implementation of immutable queue.
    
    An enqueue or dequeue will not alter the old queue and will return a new queue.
    
    After an enqueue or dequeue both the old queue and the new queue exist.
    
    The immutable queue is implemented with 2 immutable stacks.
    
    Immutable stacks are linked by the tail member of the queue.
    
    A push or pop will not copy elements of the stack so that memory can be saved.
    
    To enqueue an element just push it onto the back stack.
    
    To dequeue an element just pop the top element from the front stack.
    
    If the front stack is empty pop all elements from the back stack and push them onto the front stack.
    

2. Design Question: Design A Google Analytic like Backend System.
    We need to provide Google Analytic like services to our customers. Pls provide a high level solution design for the backend system. Feel free to choose any open source tools as you want.
	
	The system needs to:

	1) handle large write volume: Billions write events per day.
	
	2) handle large read/query volume: Millions merchants want to get insight about their business. Read/Query patterns are time-series related metrics. 
	
	3) provide metrics to customers with at most one hour delay.
	
	4) run with minimum downtime.
	
	5) have the ability to reprocess historical data in case of bugs in the processing logic.
	
ANSWER:

The backend system contains the following 4 modules.

Data collection, data processing, data storing, data analysis.


1) Data collection and pipline

    Use Kafka cluster to handles streams of large volume collected from web sites.
    
    Partition data across multiple nodes in the Kafka cluster to achieve throughput of millions of messages per second.
    
    Achieve high availabily and minimum downtime by repricating partions of data across nodes of the cluster.
    
    Use Zookeepr to keep track of cluster metadata, such as partition assignment.
    
    
2) Data processing

    Use Spark Streaming as consumers of Kafda.
    
    Spark streaming runs on Hadoop cluster.
    
    Spark streaming aggregate and compute statistics of data.
    
    
3) Data Storing 

    Use Hbase running on HDFS on top of the Hadoop cluster to store data.
    
    Metrics calculated by Spark Streaming and other raw data that is needed are written into Hbase.
    
    Replicating data across nodes in Hadoop cluster to achieve minimum downtime.
    
    Using Sharding for splitting the database into the Hadoop cluster nodes.
    
    
4) Data Analysis

    Use Spark analytics engine running on the Hadoop cluster for batch process.
    
    Spark access data stored in the Hbase NoSql database so that historical data can be reprocessed in case of any failure in the previous processing.
    
    Better performance and throughput of data analysis can be acheived by hirizonal scalling of the Hadoop cluster. 
    
    
    
