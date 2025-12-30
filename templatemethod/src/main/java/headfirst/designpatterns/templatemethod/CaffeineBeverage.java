package headfirst.designpatterns.templatemethod;

public abstract class CaffeineBeverage {

    // Template method
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    protected abstract void brew();
    protected abstract void addCondiments();

    protected void boilWater() {
        System.out.println("Boiling water");
    }

    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Hook: subclasses may override
    protected boolean customerWantsCondiments() {
        return true;
    }
}
