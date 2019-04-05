import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;


@RequestScoped@ManagedBean(name="Losowanie")

    public class Losowanie{

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String name;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String age;

        public String getPesel() {
            return pesel;
        }

        public void setPesel(String pesel) {
            this.pesel = pesel;
        }

        public String pesel;

        public void validateAge(FacesContext context, UIComponent comp, Object obj) {


            if (Integer.parseInt(this.age) <0 || Integer.parseInt(this.age)>120) {
                ((UIInput) comp).setValid(false);

                FacesMessage message = new FacesMessage(
                        "Age must be > 0 and < 120");
                context.addMessage(comp.getClientId(context), message);

            }

        }


        public String wyslij(){
            if(Math.random()<0.2){
                return "OK";
            }
            else
                return "NOT_OK";
        }
    }
