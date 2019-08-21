package org.jenkinsci

class Jobhelper implements Serializable{
    
    //def ci 
    //def jvmversion
    def steps
    def ci	    
    Jobhelper(steps){
        this.steps = steps
        this.ci="jenkins"
        //this.jvm="1.8_u221"
    }
    
    def checkoutSource(giturl,revision){
        try{
            steps.git url:"${giturl}", branch: "${revision}"
        }
        catch(err){
            steps.echo "caught exception in git checkout"
        }
        finally{
            steps.echo "finished checkout source step"
        
        }
    
    }
    
    def printStats(){
        println "hello" 
        
    
    }

}
