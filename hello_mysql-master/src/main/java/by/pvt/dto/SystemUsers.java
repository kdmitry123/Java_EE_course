package by.pvt.dto;

import java.util.Date;

public class SystemUsers {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_users.id
     *
     * @mbg.generated Fri Aug 02 16:34:34 MSK 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_users.username
     *
     * @mbg.generated Fri Aug 02 16:34:34 MSK 2019
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_users.active
     *
     * @mbg.generated Fri Aug 02 16:34:34 MSK 2019
     */
    private Boolean active;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_users.dateofbirth
     *
     * @mbg.generated Fri Aug 02 16:34:34 MSK 2019
     */
    private Date dateofbirth;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_users.id
     *
     * @return the value of system_users.id
     *
     * @mbg.generated Fri Aug 02 16:34:34 MSK 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_users.id
     *
     * @param id the value for system_users.id
     *
     * @mbg.generated Fri Aug 02 16:34:34 MSK 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_users.username
     *
     * @return the value of system_users.username
     *
     * @mbg.generated Fri Aug 02 16:34:34 MSK 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_users.username
     *
     * @param username the value for system_users.username
     *
     * @mbg.generated Fri Aug 02 16:34:34 MSK 2019
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_users.active
     *
     * @return the value of system_users.active
     *
     * @mbg.generated Fri Aug 02 16:34:34 MSK 2019
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_users.active
     *
     * @param active the value for system_users.active
     *
     * @mbg.generated Fri Aug 02 16:34:34 MSK 2019
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_users.dateofbirth
     *
     * @return the value of system_users.dateofbirth
     *
     * @mbg.generated Fri Aug 02 16:34:34 MSK 2019
     */
    public Date getDateofbirth() {
        return dateofbirth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_users.dateofbirth
     *
     * @param dateofbirth the value for system_users.dateofbirth
     *
     * @mbg.generated Fri Aug 02 16:34:34 MSK 2019
     */
    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
}