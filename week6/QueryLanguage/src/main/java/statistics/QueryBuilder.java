package statistics;

import statistics.matcher.*;

public class QueryBuilder {
	
	Matcher matcher;
	
	public QueryBuilder() {
		matcher = new All();
	}

	public Matcher build() {
		Matcher build = this.matcher;
		this.matcher = new All();
		return build;
	}
	
	public QueryBuilder playsIn(String team) {
		if(matcher instanceof All) {
			this.matcher = new PlaysIn(team);
		} else {
			this.matcher = new And(this.matcher, new PlaysIn(team));
		}
		return this;
	}

	public QueryBuilder hasAtLeast(int value, String fieldName) {
		if(matcher instanceof All) {
			this.matcher = new HasAtLeast(value, fieldName);
		} else {
			this.matcher = new And(this.matcher, new HasAtLeast(value, fieldName));
		}
		return this;
	}
	
	public QueryBuilder hasFewerThan(int value, String fieldName) {
		if(matcher instanceof All) {
			this.matcher = new HasFewerThan(value, fieldName);
		} else {
			this.matcher = new And(this.matcher, new HasFewerThan(value, fieldName));
		}
		return this;
	}
	
	public QueryBuilder oneOf(Matcher... matchers) {
		this.matcher = new Or(matchers);
		return this;
	}
}
