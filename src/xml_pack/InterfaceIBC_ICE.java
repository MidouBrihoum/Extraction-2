package xml_pack;

import java.util.List;

public class InterfaceIBC_ICE {
	
	
	List<Operation> operationList;
	List<String> KeywordsList;
	
	public InterfaceIBC_ICE(List<String> keywordsList,List<Operation> operationList) {
		super();
		this.operationList = operationList;
		KeywordsList = keywordsList;
	}

	public List<Operation> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<Operation> operationList) {
		this.operationList = operationList;
	}

	public List<String> getKeywordsList() {
		return KeywordsList;
	}

	public void setKeywordsList(List<String> keywordsList) {
		KeywordsList = keywordsList;
	}


}
