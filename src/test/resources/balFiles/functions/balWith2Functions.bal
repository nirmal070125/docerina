@Description("test method")
@Param("args: a string argument")
@Return("response: an integer")
function abc (string[] args) (int response) {
    //system:println("Hello, World! "+args[0]);
    return 5;
}

@Description("test method 2")
@Param("args: arguments")
@Param("x: integer argument")
function xyz (string[] args, int x) {
    //system:println("Hello, World! "+args[0]);
return;
}
