package com.griesba.bookingvtc.adapter;

import com.griesba.bookingvtc.domain.Vtc;
import com.griesba.bookingvtc.domain.repository.VtcRepository;

import java.util.LinkedHashSet;
import java.util.Set;

public class InMemoryVtcRepositoryImpl implements VtcRepository {
    Set<Vtc> vtcs = new LinkedHashSet<>();

    @Override
    public Vtc add(Vtc vtc) {
        vtcs.add(vtc);
        return vtc;
    }

    @Override
    public Set<Vtc> all() {
        return vtcs;
    }
}
