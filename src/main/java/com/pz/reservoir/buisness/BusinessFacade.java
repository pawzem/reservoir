package com.pz.reservoir.buisness;

import com.pz.reservoir.buisness.dto.Employee;
import com.pz.reservoir.buisness.dto.Firm;
import com.pz.reservoir.buisness.dto.Branch;
import com.pz.reservoir.buisness.dto.Workstation;
import com.pz.reservoir.party.*;
import com.pz.reservoir.party.address.TelecomAddress;
import com.pz.reservoir.party.address.WebPageAddress;
import com.pz.reservoir.relationship.PartyRelationShipRepository;
import com.pz.reservoir.relationship.RelationshipFactory;
import com.pz.reservoir.relationship.RelationshipIdentifier;
import com.pz.reservoir.relationship.relationships.CompanyBranch;
import com.pz.reservoir.relationship.relationships.Employment;
import com.pz.reservoir.relationship.relationships.WorkstationOwnership;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class BusinessFacade {

    private final PartyRepository<Company> companyPartyRepository;
    private final PartyRepository<OrganizationUnit> organizationUnitRepository;
    private final PartyRelationShipRepository<CompanyBranch> branchRelationshipRepository;
    private final PartyRelationShipRepository<WorkstationOwnership> workstationOwnershipPartyRelationShipRepository;
    private final PartyRepository<Person> employeeRepository;
    private final PartyRelationShipRepository<Employment> employmentRelationShipRepository;
    //TODO each type in different package with shared kernel? NOw commits affect to many packages

    public PartyId addCompany(Firm firmDto){
        var telecomAddress = new TelecomAddress(firmDto.getPhoneNumber());
        var webAddress = new WebPageAddress(firmDto.getWebsite());
        var email = new WebPageAddress(firmDto.getEmail());
        List<Address> addresses = List.of(telecomAddress, webAddress, email);


        var  company = PartyFactory.createCompany(firmDto.getDisplayName(), addresses, List.of(), Set.of());

        return companyPartyRepository.save(company);
    }

    public Company getCompany(PartyId id){
        return companyPartyRepository.find(id);
    }

    public OrganizationUnit geBranch(PartyId branchId){
        return organizationUnitRepository.find(branchId);
    }

    public CompanyBranch getBranchRelationship(RelationshipIdentifier branchRelationshipId){
        return branchRelationshipRepository.find(branchRelationshipId);
    }

    public RelationshipIdentifier addBranch(Branch branchDto){
        PartyId branchId = createBranch(branchDto);

        var branchRelationship = RelationshipFactory.createBranchCompany(PartyIdFactory.of(branchDto.getOrganizationId()), branchId);

        return branchRelationshipRepository.save(branchRelationship);
    }

    private PartyId createBranch(Branch branchDto) {
        var telecomAddress = new TelecomAddress(branchDto.getPhoneNumber());
        var webAddress = new WebPageAddress(branchDto.getWebsite());
        var email = new WebPageAddress(branchDto.getEmail());
        List<Address> addresses = List.of(telecomAddress, webAddress, email);


        var  branch = PartyFactory.createUnit(branchDto.getDisplayName(), addresses, List.of(), Set.of());

        return organizationUnitRepository.save(branch);
    }

    public RelationshipIdentifier addWorkstation(Workstation workstationDto){
        //TODO
        PartyId workstationId = createWorkstation(workstationDto);
        WorkstationOwnership workstationRelationship = RelationshipFactory.createWorkstationRelationship(PartyIdFactory.of(workstationDto.getOrganizationUnitId()), workstationId);
        return workstationOwnershipPartyRelationShipRepository.save(workstationRelationship);
    }

    private PartyId createWorkstation(Workstation workstationDto) {
        var  workstation = PartyFactory.createUnit(workstationDto.getDisplayName(), List.of(), List.of(), Set.of());
        return organizationUnitRepository.save(workstation);
    }

    public OrganizationUnit getWorkStation(PartyId workstationId){
        return organizationUnitRepository.find(workstationId);
    }

    public WorkstationOwnership getWorkstationRelationship(RelationshipIdentifier workstationRelationshipId){
        return workstationOwnershipPartyRelationShipRepository.find(workstationRelationshipId);
    }

    public RelationshipIdentifier addEmployee(Employee employeeDto){
        PartyId employee = createEmployee(employeeDto);
        Employment employment = RelationshipFactory.createEmployment(employee, PartyIdFactory.of(employeeDto.getOrganizationId()));
        return employmentRelationShipRepository.save(employment);
    }

    private PartyId createEmployee(Employee employee) {
        var person = PartyFactory.createPerson(List.of(), List.of(), Set.of(), employee.getFirstName(), employee.getLastName());
        return employeeRepository.save(person);
    }

    public Employment getEmployment(RelationshipIdentifier relationshipIdentifier){
        return employmentRelationShipRepository.find(relationshipIdentifier);
    }

    public Person getEmployee(PartyId partyId){
        return employeeRepository.find(partyId);
    }
}
