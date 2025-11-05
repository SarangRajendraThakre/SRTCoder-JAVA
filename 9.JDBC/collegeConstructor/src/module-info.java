module college {
    requires spring.context;
    requires spring.beans;
    opens com.srtCoder to spring.beans; 
    // opens com.srtCoder to spring.context; // Optional, but safe to include
}