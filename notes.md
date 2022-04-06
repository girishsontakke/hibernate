@Entity - Java class mapped to database table.
@Table - Define the name of database table.
@Column - Define the name of the column in table.
@Id - Define a column as a primary key.
@GeneratedValue(strategy) - Defines the strategy for generation of primary key
@JoinColumn - specify the relations between different columns of entities

@OneToMany - in case of uni-direction relationship the `name` parameter on @JoinColumn refers to the name of attribute in
target class.
@JoinTable - refers to the joint-table of ManyToMany relationship

SessionFactory: - 
1) Reads the hibernate config file
2) Creates Session Objects
3) Heavy-weight Object
4) Only create once in your app

Session: -
1) Wraps the JDBC connection
2) Main object is used to save/retrieve objects 
3) Short-lived object
4) Retrieved from sessionFactory


# Entity LifeCycle
1) Detach:- if entity is detached, it is not associated with Hibernate.
2) Merge:- If an instance is detached from a session, then  merge will reattach to the session.
3) Persist:- Transition new instances to managed state. Next flush / commit will save in db.
4) Remove:- Transitions managed entity to be removed. Next flush / commit will delete from db.
5) Refresh:- Reload / sync object with data from db. Prevent stale data. 


# Relations
1) OneToOne
2) OneToMany
3) ManyToOne

# FETCH TYPE
1) lazy - fetch on demand
2) eager - always fetch