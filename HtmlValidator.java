import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	//If the HTML file is well formatted, the method should return an empty Stack.
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		Stack<HtmlTag> result = new Stack<>();
		
		
		
		//enhanced for loop because there's no index
		//push all open tags into result then pop those that have closingtag
		for (HtmlTag tag : tags) {
			if (tag.isOpenTag()) {
				result.push(tag);
			} else {
				if (!tag.isSelfClosing()) { //closing tag
					if (result.isEmpty()) { //all matched
						return null;		//null for file containing closing tag
					} 
					if (tag.matches(result.peek())) {
						result.pop();
					} else {
						return result;
					}
				}
			}
		} 
		
		return result;

	
	}
}

