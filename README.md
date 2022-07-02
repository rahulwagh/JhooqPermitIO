
## Start the spring boot application 

```bash
java -jar JhooqPermitIO-0.0.1-SNAPSHOT.jar
```

## Use the following docker run command to start the permit.io container

```bash 
docker run \
-p 7766:7000 \
--env PDP_API_KEY=eyJhbGciOiJSUzI1NiIsImtpZCI6IjRjYjFhYjYyLWVhZTctNDFmZS04NWMwLTAyZjFlNjMyN2FlZCIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2NTY1Mjc3MTYsImV4cCI6MTY4Nzk3NzMxNiwiYXVkIjoiaHR0cHM6Ly9hcGkucGVybWl0LmlvL3YxLyIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJtaXQuaW8vIiwic3ViIjoiMmVmYzdjNDVmZWMwNGM3OThjMGEyNjhkYjUxZDQ1ZjYifQ.D4IpYF-OoQqVyw9yyWd1kOIKxzVaqTW-ld560Js0e2ay77zUWAUF4QvuutoMH9AFzgixeY7e2PFlBjbwu-eB-S12AWElfI70zrDnHSwWQit5iniz31VzJNwhD_j49F_Oxc_vxEZLS6F_b7Esp3Dt3t7RKKTrSWXA-A1BRbsIr4xJr1doctYo5XuiSLDf2643BWwLh37VQjbBKfobgdDPdZvXl8AOB5A0o_xbBaZyM54W5twqOWGlBX5EesnE_PgxMH-lu2h0gt0Vu5IOthT-5zaOkuZX0am163BV4NgRq9N0ENs8eO3vKLJHYtPo9cJe4tynDAOdQjXnzo1l6S_gWgsj1CLRBHaKYgPna_7JY2Fcvu7emrv_OaXsH73xh48GB5renJURgEEbG923RdMI7hPHpFPsoM_mTJr51gzVBfyMwBr_8H63R1wiRttNXG3IW5vcIzeZ6PwK5Yw5eCnenOvBYHGyqOG8IzTBI5Ft99lCHTF4e-2l5NR2XupPehQWnj-tSgW4d6JITF-u_ZV9dWc0KlnwYXFbzeNA8wvT6ubIjONlX3vt7TXRHMkOuX55tH1UYFOnsxDNz4xeErwVVQBDS7H9uNLyg78gnhHdxsPelVcvQnYchcNhNf48q5TNVS91p58DZpnLj9trbkrPL9tgGGziWhjzjP9KwpXTNuI \
permitio/pdp
```




Writer - Can read and edit post
Reviewer - Can read, edit and approve post
Copywriter - Can read, edit and provide copy approval


Batman - review          - read, approve, edit
Superman - writer        - read, edit
wonderwoman - copywriter - read, copy-approval, edit