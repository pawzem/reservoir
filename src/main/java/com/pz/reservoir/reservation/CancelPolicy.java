package com.pz.reservoir.reservation;

import com.pz.reservoir.party.PartyId;

public class CancelPolicy {
    boolean validateCancel(PartyId workstationId, PartyId requester, Reservation reservation){
        boolean canCancel = reservation.isReservationOwner(requester) || isAdminForWorkstation(workstationId, workstationId);

        if(!canCancel){
            throw new UnauthorizedCancelAttemptException(requester, reservation.getId());
        }

        return true;
    }

    private boolean isAdminForWorkstation(PartyId workstationId, PartyId workstationId1) {
        return false;
        //TODO
    }
}
