import React, { useState } from "react";

function StudentManager() {

  const [students, setStudents] = useState([
    { id: 1, name: "Vikas Reddy", course: "CSE" },
    { id: 2, name: "Van", course: "ECE" },
    { id: 3, name: "Babu", course: "IT" },
    { id: 4, name: "David", course: "MECH" },
    { id: 5, name: "Karthik", course: "CIVIL" }
  ]);

  const [newStudent, setNewStudent] = useState({
    id: "",
    name: "",
    course: ""
  });

  const handleChange = (e) => {
    setNewStudent({
      ...newStudent,
      [e.target.name]: e.target.value
    });
  };

  const addStudent = () => {
    if (!newStudent.id || !newStudent.name || !newStudent.course) return;

    setStudents([...students, newStudent]);

    setNewStudent({ id: "", name: "", course: "" });
  };

  const deleteStudent = (id) => {
    const updated = students.filter((s) => s.id !== id);
    setStudents(updated);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Student Manager</h2>

      <input name="id" placeholder="ID" value={newStudent.id} onChange={handleChange} />
      <input name="name" placeholder="Name" value={newStudent.name} onChange={handleChange} />
      <input name="course" placeholder="Course" value={newStudent.course} onChange={handleChange} />

      <button onClick={addStudent}>Add Student</button>

      <hr />

      {students.length === 0 ? (
        <p>No students available</p>
      ) : (
        <table border="1" cellPadding="10">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {students.map((s) => (
              <tr key={s.id}>
                <td>{s.id}</td>
                <td>{s.name}</td>
                <td>{s.course}</td>
                <td>
                  <button onClick={() => deleteStudent(s.id)}>Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default StudentManager;