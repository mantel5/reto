
package Controller.Action.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAction {
    public String execute(
            HttpServletRequest request,
            HttpServletResponse response, String action);
}