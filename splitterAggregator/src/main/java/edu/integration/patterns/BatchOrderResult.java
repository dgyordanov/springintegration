package edu.integration.patterns;

import java.util.List;

/**
 * @author Martin
 */
public class BatchOrderResult {

	private List<OrderResult> results;

	public BatchOrderResult(List<OrderResult> results) {
		this.results = results;
	}

	public List<OrderResult> getResults() {
		return results;
	}
	
	public void setResults(List<OrderResult> results) {
		this.results = results;
	}
	
	@Override
	public String toString() {
		return results.toString();
	}
}
