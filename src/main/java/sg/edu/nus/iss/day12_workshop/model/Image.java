package sg.edu.nus.iss.day12_workshop.model;

public class Image {

    //this is just a plain java class to populate data.
    //must have property, getter setter

    //2 constructor, 2 getter setter, 2 string method

    //even if not using constructors, create it

    //this is pojo -> plain old java object (i.e. the basic stuff u expect from a class like gettersetterconstructor etc.
    //all entities should be creating classes like this (?)
    
    private String name;
    private String path;
    
    public Image(){
    }


    public Image(String name, String path) {
        this.name = name;
        this.path = path;
    }


    //getters setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Image [name=" + name + ", path=" + path + "]";
    }



}
