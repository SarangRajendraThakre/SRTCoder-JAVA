module Spring2Xml {
    // Requires statements for the core Spring modules
    requires spring.context;
    requires spring.beans;
    requires spring.core;
    // Add any other spring modules you need, like:
    // requires spring.expression;
    exports com.srt;
}