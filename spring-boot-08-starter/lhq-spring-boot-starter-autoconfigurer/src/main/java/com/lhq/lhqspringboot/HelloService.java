package com.lhq.lhqspringboot;
public class HelloService {
    HelloProperties helloProperties;
    public HelloProperties getHelloProperties() {
        return helloProperties;
    }
    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
    public String sayHelloLhq(String name){
       return helloProperties.getPrefix()+"-"+name + helloProperties.getSuffix();
    }
}
