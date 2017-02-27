package com.petstore.dao;

import org.springframework.stereotype.Component;

import com.petstore.domain.Sequence;

public interface SequenceDAO {
	Sequence getSequence(Sequence sequence);
	  void updateSequence(Sequence sequence);

}
