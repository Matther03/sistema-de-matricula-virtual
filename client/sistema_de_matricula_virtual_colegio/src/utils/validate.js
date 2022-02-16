export const fieldsHaveErrors = (errors) => {
    return Object.values(errors).some(error => error);
}