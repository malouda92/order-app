CREATE TABLE public."client" (
  id varchar(36) NOT NULL,
  nom varchar(50) NOT NULL,
  prenom varchar(50) NOT NULL,
  adresse varchar(100) NOT NULL,
  telephone varchar(13) NOT NULL
);

ALTER TABLE ONLY public."client"
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);

CREATE TABLE public."commande" (
  id varchar(36) NOT NULL,
  date_commande varchar(20) NOT NULL,
  adresse_livraison varchar(100) NOT NULL,
  id_client varchar(36) NOT NULL
);

ALTER TABLE ONLY public."commande"
    ADD CONSTRAINT comande_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public."commande"
    ADD CONSTRAINT "FK_commande.id_client" FOREIGN KEY (id_client) REFERENCES public."client"(id);

CREATE TABLE public."produit" (
  id varchar(36) NOT NULL,
  libelle varchar(100) NOT NULL,
  packaging varchar(30) NOT NULL,
  poids numeric NOT NULL,
  unite varchar(2) NOT NULL
);

ALTER TABLE ONLY public."produit"
    ADD CONSTRAINT produit_pkey PRIMARY KEY (id);

CREATE TABLE public."commande_item" (
  id_commande varchar(36) NOT NULL,
  id_produit varchar(36) NOT NULL,
  quantite integer NOT NULL
);

ALTER TABLE public."commande_item"
    ADD CONSTRAINT "FK_commande_item.id_commande" FOREIGN KEY (id_commande) REFERENCES public."commande"(id);

ALTER TABLE public."commande_item"
    ADD CONSTRAINT "FK_commande_item.id_produit" FOREIGN KEY (id_produit) REFERENCES public."produit"(id);