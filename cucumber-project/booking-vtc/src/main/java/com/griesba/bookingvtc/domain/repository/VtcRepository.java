package com.griesba.bookingvtc.domain.repository;

import com.griesba.bookingvtc.domain.Vtc;

import java.util.Set;

public interface VtcRepository {

    Vtc add(Vtc vtc);

    Set<Vtc> all();
}
