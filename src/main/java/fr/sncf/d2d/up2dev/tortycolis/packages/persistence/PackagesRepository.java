package fr.sncf.d2d.up2dev.tortycolis.packages.persistence;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.sncf.d2d.up2dev.tortycolis.packages.models.Pagination;
import fr.sncf.d2d.up2dev.tortycolis.packages.models.Package;
import fr.sncf.d2d.up2dev.tortycolis.packages.models.PackageStatus;
import fr.sncf.d2d.up2dev.tortycolis.packages.usecases.params.PaginatePackagesParams;

@Repository
public class PackagesRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public PackagesRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Pagination<Package> paginate(PaginatePackagesParams params){
        final var selectQuery = "SELECT * FROM packages ORDER BY id ASC OFFSET :offset LIMIT :limit";
        final var countQuery = "SELECT COUNT(id) FROM packages";

        final var total = this.jdbcTemplate.queryForObject(countQuery, Collections.emptyMap(), Long.class);

        final var selectParameters = Map.of(
            "offset", params.getPage() * params.getItemsPerPage(),
            "limit", params.getItemsPerPage()
        );

        final var packages = this.jdbcTemplate.queryForStream(
            selectQuery, 
            selectParameters, 
            (resultSet, n) -> Package.builder()
                .id(UUID.fromString(resultSet.getString("id")))
                .email(resultSet.getString("email"))
                .street(resultSet.getString("street"))
                .city(resultSet.getString("city"))
                .number(resultSet.getString("number"))
                .status(PackageStatus.valueOf(resultSet.getString("status").toUpperCase()))
                .details(resultSet.getString("details"))
                .country(resultSet.getString("country"))
                .postalCode(resultSet.getString("postal_code"))
                .phoneNumber(resultSet.getString("phone_number"))
                .trackingCode(resultSet.getString("tracking_code"))
                .build()
        ).toList();

        return new Pagination<>(packages, total);
    }

    public void save(Package pack) {
        pack.setId(UUID.randomUUID());
        final var query = "INSERT INTO packages "
            + "(id, number, street, city, phone_number, details, country, email, status, tracking_code) "
            + "VALUES (:id, :number, :street, :city, :phoneNumber, :details, :country, :email, :status::package_status, :trackingCode)";
        this.jdbcTemplate.update(
            query,
            Map.of(
                "id", pack.getId(),
                "street", pack.getStreet(),
                "number", pack.getNumber(),
                "city", pack.getCity(),
                "phoneNumber", pack.getPhoneNumber(),
                "details", pack.getDetails(),
                "country", pack.getCountry(),
                "email", pack.getEmail(),
                "status", pack.getStatus().toString().toLowerCase(),
                "trackingCode", pack.getTrackingCode()
            )
        );
    }
}