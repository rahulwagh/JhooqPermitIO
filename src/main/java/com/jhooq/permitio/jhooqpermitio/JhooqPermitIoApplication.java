package com.jhooq.permitio.jhooqpermitio;

import io.permit.sdk.Permit;
import io.permit.sdk.PermitConfig;
import io.permit.sdk.api.PermitApiException;
import io.permit.sdk.enforcement.Resource;
import io.permit.sdk.enforcement.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@SpringBootApplication
public class JhooqPermitIoApplication {

private String apiKey =
		"eyJhbGciOiJSUzI1NiIsImtpZCI6IjRjYjFhYjYyLWVhZTctNDFmZS04NWMwLTAyZjFlNjMyN2FlZCIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2NTY1Mjc3MTYsImV4cCI6MTY4Nzk3NzMxNiwiYXVkIjoiaHR0cHM6Ly9hcGkucGVybWl0LmlvL3YxLyIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJtaXQuaW8vIiwic3ViIjoiMmVmYzdjNDVmZWMwNGM3OThjMGEyNjhkYjUxZDQ1ZjYifQ.D4IpYF-OoQqVyw9yyWd1kOIKxzVaqTW-ld560Js0e2ay77zUWAUF4QvuutoMH9AFzgixeY7e2PFlBjbwu-eB-S12AWElfI70zrDnHSwWQit5iniz31VzJNwhD_j49F_Oxc_vxEZLS6F_b7Esp3Dt3t7RKKTrSWXA-A1BRbsIr4xJr1doctYo5XuiSLDf2643BWwLh37VQjbBKfobgdDPdZvXl8AOB5A0o_xbBaZyM54W5twqOWGlBX5EesnE_PgxMH-lu2h0gt0Vu5IOthT-5zaOkuZX0am163BV4NgRq9N0ENs8eO3vKLJHYtPo9cJe4tynDAOdQjXnzo1l6S_gWgsj1CLRBHaKYgPna_7JY2Fcvu7emrv_OaXsH73xh48GB5renJURgEEbG923RdMI7hPHpFPsoM_mTJr51gzVBfyMwBr_8H63R1wiRttNXG3IW5vcIzeZ6PwK5Yw5eCnenOvBYHGyqOG8IzTBI5Ft99lCHTF4e-2l5NR2XupPehQWnj-tSgW4d6JITF-u_ZV9dWc0KlnwYXFbzeNA8wvT6ubIjONlX3vt7TXRHMkOuX55tH1UYFOnsxDNz4xeErwVVQBDS7H9uNLyg78gnhHdxsPelVcvQnYchcNhNf48q5TNVS91p58DZpnLj9trbkrPL9tgGGziWhjzjP9KwpXTNuI";
private String pdpURL = "http://localhost:7766";

	// You can open http://localhost:4000 to invoke this http
	// endpoint, and see the outcome of the permission check.
	@PostMapping("/")
	ResponseEntity<String> home(@RequestParam final String fName,
								@RequestParam final String lName,
								@RequestParam final String emailId) throws IOException{
		Permit permit = new Permit(
				new PermitConfig.Builder(apiKey)
						.withPdpAddress(pdpURL)
						.withDebugMode(true)
						.build()
		);

		User user = new User.Builder(emailId)
				.withEmail(emailId)
				.withFirstName(fName)
				.withLastName(lName)
				.build();

		boolean permitted = permit.check(
				user,
				"edit",
				Resource.fromString("jhooq-blog")
		);

		if (permitted) {
			return ResponseEntity.status(HttpStatus.OK).body(
					"You have a permission to edit article"
			);
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
					"You don't have permission to edit"
			);
		}
	}

	@PostMapping("/updateRole")
	ResponseEntity<String> updateRole(@RequestParam final String emailId,
									  @RequestParam final String role) throws IOException,
			PermitApiException {
		// init the permit SDK
		Permit permit = new Permit(
				new PermitConfig.Builder(apiKey)
						.withPdpAddress(pdpURL)
						.withDebugMode(true)
						.build()
		);

		permit.api.assignRole(emailId,
				role,
				"default");
		return ResponseEntity.status(HttpStatus.OK).body("Successfully update the role " + role);
	}

	@DeleteMapping("/")
	ResponseEntity<String> deleteRole(@RequestParam final String fName,
									  @RequestParam final String lName,
									  @RequestParam final String emailId) throws IOException {
		Permit permit = new Permit(
				new PermitConfig.Builder(apiKey)
						.withPdpAddress(pdpURL)
						.withDebugMode(true)
						.build()
		);

		User user = new User.Builder(emailId)
				.withFirstName(fName)
				.withLastName(lName)
				.withEmail(emailId)
				.build();

		boolean permitted = permit.check(
				user,
				"delete",
				Resource.fromString("jhooq-blog")
		);

		if (permitted) {
			return ResponseEntity.status(HttpStatus.OK).body(
					"Deleted Successfully"
			);
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
					"You don't have permission to delete"
			);
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(JhooqPermitIoApplication.class, args);
	}

}

