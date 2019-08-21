
class Jobhelper implements Serializable{
    
    def ci 
    def jvmversion
    def steps
    
    Jobhelper(steps,ci="jenkins",jvm="1.8_u221"){
        this.steps = steps
        this.ci=ci
        this.jvm=jvm
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
        println this.ci 
        println this.jvm
    
    }

}
